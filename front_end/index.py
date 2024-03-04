import webview
import subprocess as sp
import os 
from globalz import *



def open_folder_dialog():
    # Function to open folder dialog
    result = windows["main"].create_file_dialog(webview.FOLDER_DIALOG )[0]
    # print(result)
    return result


def evaluate_llm(path, cmd):
    os.chdir(path)
    sp.run([cmd])