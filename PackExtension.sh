#!/bin/bash
resource_path="./ui/src/main/resources/extensions/*.crx"
extension_path="./../main"
extension_key="CalamariCrew.pem"
chrome.exe --pack-extension=[$extension_path] --pack-extension-key=[$extension_key]
rm resource_path
mv CalamariCrew.crx ./ui/src/main/resources/extensions
