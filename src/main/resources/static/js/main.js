'use strict';

var contentUploadForm = document.querySelector('#contentUploadForm');
var contentUploadInput = document.querySelector('#contentUploadInput');
var contentUploadError = document.querySelector('#contentUploadError');
var contentUploadSuccess = document.querySelector('#contentUploadSuccess');


var cssContentUploadForm = document.querySelector('#cssContentUploadForm');
var cssContentUploadInput = document.querySelector('#cssContentUploadInput');
var cssContentUploadError = document.querySelector('#cssContentUploadError');
var cssContentUploadSuccess = document.querySelector('#cssContentUploadSuccess');

function uploadcontent(file) {
    var formData = new FormData();
    var baseUrl = "/theme/1/content/upload";
    formData.append("file", file);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", baseUrl);

    xhr.onload = function() {
        console.log(xhr.responseText);
        var response = JSON.parse(xhr.responseText);
        if(xhr.status == 200) {
            contentUploadError.style.display = "none";
            contentUploadSuccess.innerHTML = "<p>File Uploaded Successfully.</p><p>DownloadUrl : <a href='" + response.fileDownloadUri + "' target='_blank'>" + response.fileDownloadUri + "</a></p>";
            contentUploadSuccess.style.display = "block";
        } else {
            contentUploadSuccess.style.display = "none";
            contentUploadError.innerHTML = (response && response.message) || "Some Error Occurred";
        }
    }

    xhr.send(formData);
}

contentUploadForm.addEventListener('submit', function(event){
    var files = contentUploadInput.files;
    if(files.length === 0) {
        contentUploadError.innerHTML = "Please select a file";
        contentUploadError.style.display = "block";
    }
    uploadcontent(files[0]);
    event.preventDefault();
}, true);




function uploadCssContent(file) {
    var formData = new FormData();
    var baseUrl = "/theme/1/csscontent/upload";
    formData.append("file", file);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", baseUrl);

    xhr.onload = function() {
        console.log(xhr.responseText);
        var response = JSON.parse(xhr.responseText);
        if(xhr.status == 200) {
            cssContentUploadError.style.display = "none";
            cssContentUploadSuccess.innerHTML = "<p>File Uploaded Successfully.</p><p>DownloadUrl : <a href='" + response.fileDownloadUri + "' target='_blank'>" + response.fileDownloadUri + "</a></p>";
            cssContentUploadSuccess.style.display = "block";
        } else {
            cssContentUploadSuccess.style.display = "none";
            cssContentUploadError.innerHTML = (response && response.message) || "Some Error Occurred";
        }
    }

    xhr.send(formData);
}

cssContentUploadForm.addEventListener('submit', function(event){
    var files = cssContentUploadInput.files;
    if(files.length === 0) {
        cssContentUploadError.innerHTML = "Please select a file";
        cssContentUploadError.style.display = "block";
    }
    uploadCssContent(files[0]);
    event.preventDefault();
}, true);

