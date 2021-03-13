import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {HttpEventType, HttpResponse} from "@angular/common/http";
import {UploadFileService} from "../../service/upload-file.service";

@Component({
  selector: 'app-upload-files',
  templateUrl: './upload-files.component.html',
  styleUrls: ['./upload-files.component.css']
})
export class UploadFilesComponent implements OnInit {

  selectedFiles: FileList | undefined;
  currentFile: File | undefined;
  progress: number = 0;
  message: string = '';

  fileInfos: Observable<any>;

  constructor(private uploadService: UploadFileService) { }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  upload() {
    this.progress = 0;

    this.currentFile = this.selectedFiles.item(0);
    this.uploadService.upload(this.currentFile).subscribe(
      event => {
              if (event.type === HttpEventType.UploadProgress) {
                this.progress = Math.round(100 * event.loaded / event.total);
              } else if (event instanceof HttpResponse) {
                this.message = event.body.message;
                this.fileInfos = this.uploadService.getFiles();
              }
            },
          error => {
                this.progress = 0;
                this.message = 'Nie można było załadować pliku!';
                this.currentFile = undefined;
          });
        this.selectedFiles = undefined;
  }

  ngOnInit(): void {
    this.fileInfos = this.uploadService.getFiles();
  }

}
