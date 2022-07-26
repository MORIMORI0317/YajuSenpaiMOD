@echo off

md coverted 

for %%a in (*.ogg) do (
  ffmpeg -i %%a -ac 1 coverted/%%a
) 