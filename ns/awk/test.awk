#!/usr/bin/awk  -f
/r/ {print x+=$6,$0}
