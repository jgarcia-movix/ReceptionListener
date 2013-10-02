#!/bin/sh

###############

black='\033[30m'
red='\033[31m'
green='\033[32m'
yellow='\033[33m'
blue='\033[34m'
magenta='\033[35m'
cyan='\033[36m'
white='\033[37m'

cecho (){                    # Color-echo (message, color)
    local default_msg=""         # Doesn't really need to be a local variable.
    message=${1:-$default_msg}   # Defaults to default message.
    color=${2:-$black}           # Defaults to black, if not specified.

    echo "$color"
    echo "$message"
    tput sgr0                    #  Reset text attributes to normal + without clearing screen.

    return
}

###############

    #deployment
    cecho "Deploying..." ${green};
    rm -rf ./deploy
    ant deploy -f ./build.xml


