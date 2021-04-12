import { ActivationStart } from "@angular/router";
import { Art } from "./art";

export interface Usuario {

  userid?: number;
  username: string;
  pass: string;
  description?: string;
  pics?: string;
  Joindate?: string;
  arts?: Art;
  accounts?: Account;
  comments?: Comment;
  avatar?: string;


}
