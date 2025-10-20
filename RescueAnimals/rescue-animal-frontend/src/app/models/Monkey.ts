export interface Monkey {
  id?: string;  //Unique ID for MongoDB
  name: string;
  species: string;
  gender: string;
  age: number;
  weight: number;
  height: number;
  tailLength: number;
  bodyLength: number;
  acquisitionDate: string;
  acquisitionLocation: string;
  trainingStatus: string;
  reserved: boolean;
  inServiceLocation: string;
}