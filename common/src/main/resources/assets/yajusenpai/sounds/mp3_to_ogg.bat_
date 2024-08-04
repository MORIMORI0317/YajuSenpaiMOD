@echo off

md coverted

for %%a in (*.mp3) do (
  ffmpeg -i %%a -ac 1 coverted/%%a.ogg
)