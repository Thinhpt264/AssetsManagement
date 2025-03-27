import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { lastValueFrom } from "rxjs";
import { BaseUrlService } from "./BaseUrl.service";

@Injectable()
export class ProductService {
  constructor(
    private baseUrlService: BaseUrlService,
    private httpClient: HttpClient
  ) {}

  async findAll(): Promise<any> {
    // return await this.httpClient.get(this.baseUrlService.getBaseUrl() + "artist/findAll");
    return await lastValueFrom(
      this.httpClient.get(this.baseUrlService.getBaseUrl() + 'asset/getAssets'));
  }

  async delete(id: number): Promise<any> {
    return await lastValueFrom(this.httpClient.delete(this.baseUrlService.getBaseUrl() + 'asset/deleteAsset/' + id));
  }


}