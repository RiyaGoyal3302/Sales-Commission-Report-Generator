import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

interface CommissionData {
  salesmanName: string;
  product: string;
  salesmanArea: string;
  productQuantity: number;
  salesAmount: number;
  salesmanCommission: number;
  //selectedDate : Date;

}

interface SalesmanPopupData {
  salesmanName: string;
  salesmanArea: string;
  totalSalesAmount: number;
  totalSalesmanCommission:number;
}

interface ProductPopupData {
  product: string;
  salesmanArea: string;
  totalProductQuantity: number;
  totalSalesAmount: number;
}

@Injectable({
  providedIn: 'root'
})
export class CommissionService {
  private baseUrl = 'http://localhost:8080/sales';

  constructor(private http: HttpClient) { }

  getCommissionData(date: string): Observable<CommissionData[]> {
    const url = `${this.baseUrl}/commission?date=${date}`;
    return this.http.get<CommissionData[]>(url);
  }

  getSalesmanData(salesmanName: string): Observable<SalesmanPopupData[]> {
    const url = `${this.baseUrl}/salesman?name=${salesmanName}`;
    return this.http.get<SalesmanPopupData[]>(url);
  }

  getProductData(product: string): Observable<ProductPopupData[]> {
    const url = `${this.baseUrl}/product?name=${product}`;
    return this.http.get<ProductPopupData[]>(url);
  }
}