import { Injectable } from "@angular/core";

@Injectable()
export class BaseUrlService {
    private baseUrl: string = "http://localhost:8081/api/";
    private imageUrl: string = "http://localhost:8081/assets/images/";
    
    getBaseUrl(): string {
        return this.baseUrl;
    }

    getImageUrl(): string {
        return this.imageUrl;
    }
}
    