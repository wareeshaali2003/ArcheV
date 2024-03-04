import webview

def open_folder_dialog():
    folder_path = webview.create_file_dialog(webview.FOLDER_DIALOG)
    return folder_path

if __name__ == '__main__':
    webview.create_window("Folder Selection")
    webview.start(open_folder_dialog, debug=True)
