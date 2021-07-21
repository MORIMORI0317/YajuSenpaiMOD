@echo off

md coverted

for %%a in (*) do (
  ffmpeg -i %%a -ac 1 coverted/%%a.ogg
)