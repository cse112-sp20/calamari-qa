#!/bin/bash
FILE="./../main/root/src/js/main.js"
sed -i -e "s/interactiveSignIn;/localStorage.setItem('token','c854140ea88243c5f66168c73bea5ac29fea91b8');/g" $FILE
