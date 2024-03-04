import webview
from globalz import *
from front_end.expose_functs import *

# Drivers code
if __name__ == "__main__":
    windows["main"] = webview.create_window(title="ArcheV", url="front_end/web/index.html", resizable=False,width=1570,height=900)
    webview.start(expose, [windows["main"]], debug=True)