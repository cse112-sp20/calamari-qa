#!/bin/bash
FILE="./../main/root/src/js/main.js"
sed -i -e "s/interactiveSignIn;/localStorage.setItem('token','${ACCESS_TOKEN}');/g" $FILE
