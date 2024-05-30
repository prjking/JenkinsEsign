Sleep(1000)
ControlFocus("Open","","Edit1")
ControlSetText("Open","","Edit1", @ScriptDir & "\Test cases.docx")
ControlClick("Open","","Button1")