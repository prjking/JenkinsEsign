Sleep(1000)
ControlFocus("Open", "", "Edit1")
ControlSetText("Open", "", "Edit1", @ScriptDir & "\TESTING.pdf")
ControlClick("Open", "", "Button1")
