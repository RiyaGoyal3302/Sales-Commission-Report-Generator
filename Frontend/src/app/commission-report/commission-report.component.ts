import { Component, OnInit } from '@angular/core';
import { CommissionService } from './commission.service';
interface CommissionData {
  salesmanName: string;
  product: string;
  salesmanArea: string;
  productQuantity: number;
  salesAmount: number;
  salesmanCommission: number;
  
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

@Component({
  selector: 'app-commission-report',
  templateUrl: './commission-report.component.html',
  styleUrls: ['./commission-report.component.css']
})
export class CommissionReportComponent implements OnInit {
  selectedDate: string = '';
  commissionData: CommissionData[] = [];
  salesmanPopupData: SalesmanPopupData [] = [];
  productPopupData: ProductPopupData [] = [];
  
  constructor(private commissionService: CommissionService) { }

  ngOnInit(): void {
  }

  getCommissionData(): void {
    if (this.selectedDate) {
      this.commissionService.getCommissionData(this.selectedDate)
        .subscribe(data => this.commissionData = data);
  }
  else{
    alert("Please select date");
  }
  }
  sortCommissionData(sortBy: string): void {
    this.commissionData.sort((a, b) => {
      if ((a as any)[sortBy] < (b as any)[sortBy]) {
        return -1;
      } else if ((a as any)[sortBy] > (b as any)[sortBy]) {
        return 1;
      } else {
        return 0;
      }
    });
  }

  showSalesmanPopup(salesmanName: string): void {
    this.commissionService.getSalesmanData(salesmanName)
      .subscribe(data => this.salesmanPopupData = data);
  }

  showProductPopup(product: string): void {
    this.commissionService.getProductData(product)
      .subscribe(data => this.productPopupData = data);
  }
}