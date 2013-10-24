#!/bin/sh
jps | egrep "ReceptionListenerJPGG" | cut -d " " -f 1 | xargs kill -9
sh deploy.sh
ant run

tail -F /srv/produccion/log/ReceptionListenerJPGG.log | egrep "ReceptionListenerJPGG"

