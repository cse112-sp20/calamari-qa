#!/bin/bash
resource_path="./ui/src/main/resources/extensions/*.crx"
extension_path="./../main"
extension_key="CalamariCrew.pem"
rm $resource_path
chrome.exe --pack-extension=[$extension_path] 
crxmake --pack-extension=./CalamariCrew --extension-output="./ui/src/main/resources/extensions/velocity_raptor.crx"
