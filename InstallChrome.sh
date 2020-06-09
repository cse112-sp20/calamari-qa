#!/bin/sh
set -ex
sh -c "wget -nv $*"
wget https:://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
sudo apt install ./google-chrome-stable_current_amd64.deb
