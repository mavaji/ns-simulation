set ns [new Simulator]

set tf [open out.tr w]
$ns trace-all $tf

set numNodes 4
set qsize 21
set lambda 30.0
set mu 33.0
set duration 2000

# creating nodes
for {set j 1} {$j <= $numNodes} {incr j} {
    set node($j) [$ns node]
}

# connecting nodes
for {set j 1} {$j < $numNodes} {incr j} {
    $ns simplex-link $node($j) $node([expr $j+1]) 100kb 0ms DropTail
    $ns queue-limit $node($j) $node([expr $j+1]) $qsize
}

# generate random interarrival times and packet sizes
set InterArrivalTime [new RandomVariable/Exponential]
$InterArrivalTime set avg_ [expr 1/$lambda]
set pktSize [new RandomVariable/Exponential]
$pktSize set avg_ [expr 100000.0/(8*$mu)]

set src [new Agent/UDP]
$src set packetSize_ 100000 
$ns attach-agent $node(1) $src

proc finish {} {
	global ns tf
	$ns flush-trace
	close $tf
	exit 0
}

proc sendpacket {} {
	global ns src InterArrivalTime pktSize
	set time [$ns now]
	$ns at [expr $time + [$InterArrivalTime value]] "sendpacket"
	set bytes [expr round ([$pktSize value])]
	$src send $bytes
}

set sink [new Agent/Null]
$ns attach-agent $node($numNodes) $sink
$ns connect $src $sink
$ns at 0.0001 "sendpacket"
$ns at $duration "finish"

$ns run
