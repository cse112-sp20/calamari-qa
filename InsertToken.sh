#!/bin/bash
FILE="./../main/root/src/js/main.js"
sed -i -e "s/interactiveSignIn;/localStorage.setItem('token','a7860421a05b85ebae92c2d1dd14601217f016bd');/g" $FILE
