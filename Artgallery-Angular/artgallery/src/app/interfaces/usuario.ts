import { ActivationStart } from "@angular/router";
import { Art } from "./art";

export interface Usuario {

  userId?: number;
  username?: string;
  pass: string;
  description?: string;
  pics?: string;
  joinDate?: string;
  arts?: Art[];
  accounts?: Account[];
  comments?: Comment[];
  avatar?: string;

}
