#!/usr/bin/bash
FILE="./../main/root/src/js/main.js"
sed -i -e "s/interactiveSignIn;/localStorage.setItem('token','9fbd7ff7a891faa714ef781fce59dd118433fabd');/g" $FILE
