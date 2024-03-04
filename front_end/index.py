import webview
from globalz import *



def open_folder_dialog():
    # Function to open folder dialog
    result = windows["main"].create_file_dialog(webview.FOLDER_DIALOG )[0]
    # print(result)
    return result 
