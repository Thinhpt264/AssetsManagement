import { Component, Injectable, OnInit } from "@angular/core";
import { ProductService } from "../service/product.service";
import { ConfirmationService, MessageService } from "primeng/api";


@Component({
  selector: 'app-root',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
})
export class ProductComponent implements OnInit {
  products: any;
  constructor(
    private productService: ProductService,
    private messageService: MessageService,
    private confirmationService: ConfirmationService,
  ) { }
  ngOnInit(): void {
    this.findAll();
  }
  findAll() {
    this.productService.findAll().then((res) => {
      console.log(res.assets);
      this.products = res.assets;
    });
  }
  deleteAssest(id: number) {
    console.log("xóa" + id);
    this.confirmationService.confirm({
      message: 'Bạn có chắc chắn muốn xóa tài sản này không?',
      header: 'Xác nhận xóa',
      icon: 'pi pi-exclamation-triangle',
      acceptIcon: 'none',
      rejectIcon: 'none',
      acceptLabel: 'Đồng ý',
      rejectLabel: 'Hủy bỏ',
      rejectButtonStyleClass: 'p-button-text',
      accept: () => {
        this.productService.delete(id).then(
          (error) => {
            console.log("aaaaa");
            this.messageService.add({
              severity: 'error',
              summary: 'Lỗi',
              detail: 'Không thể xóa',
            });
            this.findAll();
          },
          (res) => {
            this.messageService.add({
              severity: 'success',
              summary: 'Thành Công',
              detail: 'Xóa được rồi',
            });
            this.findAll();
          }
        );
      },
      reject: () => {
        this.messageService.add({
          severity: 'error',
          summary: 'Xác nhận hủy',
          detail: 'Hủy thao tác xóa .',
          life: 3000,
        });
      },
    });
    }

}