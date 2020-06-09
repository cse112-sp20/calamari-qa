#!/bin/sh
set -ex
sh -c "wget -nv dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb"
sudo apt install ./google-chrome-stable_current_amd64.deb
