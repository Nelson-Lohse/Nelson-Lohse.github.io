export interface Dog {
  id?: string;                // Unique ID for MongoDB
  name: string;
  breed: string;
  gender: string;
  age: number;
  weight: number;
  acquisitionDate: string;     
  acquisitionLocation: string;
  trainingStatus: string;
  reserved: boolean;
  inServiceLocation: string;
}