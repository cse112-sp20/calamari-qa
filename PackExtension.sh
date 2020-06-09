#!/bin/bash
resource_path="/ui/main/resources/extensions/velocity_raptor.crx"
# TODO: Here extension path should be root folder of Velocity Raptor extension.
extension_path=""
extension_key="CalamariCrew.pem"
chrome.exe --pack-extension=[$extension_path] --pack-extension-key=[$extension_key]
rm resource_path
mv CalamariCrew.crx $resource_path
