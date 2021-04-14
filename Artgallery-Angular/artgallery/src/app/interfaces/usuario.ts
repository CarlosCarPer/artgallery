import { ActivationStart } from "@angular/router";
import { Art } from "./art";

export interface Usuario {

  userId?: number;
  username?: string;
  password: string;
  description?: string;
  pics?: string;
  Joindate?: string;
  arts?: Art;
  accounts?: Account;
  comments?: Comment;
  avatar?: string;

}
