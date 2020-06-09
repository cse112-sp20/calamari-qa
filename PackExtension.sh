#!/bin/bash
resource_path="/ui/main/resources/extensions/velocity_raptor.crx"
extension_path="./../main"
extension_key="CalamariCrew.pem"
chrome.exe --pack-extension=[$extension_path] --pack-extension-key=[$extension_key]
rm resource_path
mv CalamariCrew.crx $resource_path
