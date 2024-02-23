document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('browseFileBtn').addEventListener('click', function() {
        document.getElementById('fileInput').click();
    });

    document.getElementById('fileInput').addEventListener('change', function() {
        var file = this.files[0];
        if (file) {
            var filePathInput = document.getElementById('filePathInput');
            filePathInput.value = URL.createObjectURL(file);
        }
    });
});
