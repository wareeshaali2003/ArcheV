async function open_folder_dialog() {
    let  folderPath = await pywebview.api.open_folder_dialog();
    console.log(folderPath); 
    console.log(typeof(folderPath));
    document.getElementById("folderPathInput").value = folderPath;
}
async function evaluate_llm(){
    
    let path = document.getElementById("folderPathInput").value;
    let cmd = document.getElementById("command").value;
    let  eval = await pywebview.api.evaluate_llm(path, cmd);

}