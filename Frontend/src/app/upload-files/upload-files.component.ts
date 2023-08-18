import { Component} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Component({
  selector: 'app-upload-files',
  templateUrl: './upload-files.component.html',
  styleUrls: ['./upload-files.component.css']
})
export class UploadFilesComponent{

  

  private baseUrl = 'http://localhost:8080/sales';
  

  constructor(private http: HttpClient) { }

  // 
  salesman!: any[];
  products!:any[];
  
  onSalesmanFileSelected(event:any): void {
    const fileList = (event.target as HTMLInputElement).files;
    
    if (fileList && fileList.length > 0) {
      const file: File = fileList[0];
      const reader = new FileReader();
    reader.readAsText(file);
    reader.onload=() => {
      this.salesman=JSON.parse(reader.result as string);
    };
    }
  }
  
  onProductFileSelected(event: any): void {
    const fileList = (event.target as HTMLInputElement).files;
    if (fileList && fileList.length > 0) {
      const file: File = fileList[0];
      const reader = new FileReader();
    reader.readAsText(file);
    reader.onload=() => {
      this.products=JSON.parse(reader.result as string);
    };
    }
  }

  onUpload(): void {
   if(this.salesman==null || this.products==null){
    alert("Please select both files.");
    return;

   }
    const sales:any={
      salesman:this.salesman,
      products:this.products
    };
    
    this.http.post<any>(this.baseUrl, sales).subscribe(Response => {
      alert('Files uploaded successfully!');
    });
  }
}