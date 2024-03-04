async function open_folder_dialog() {
    let  folderPath = await pywebview.api.open_folder_dialog();
    console.log(folderPath); 
    console.log(typeof(folderPath));
    document.getElementById("folderPathInput").value = await pywebview.api.open_folder_dialog();
}
