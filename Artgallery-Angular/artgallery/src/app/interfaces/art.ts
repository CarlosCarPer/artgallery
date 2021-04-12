import { Usuario } from "./usuario";

export interface Art {

  artid?: number;
  title: string;
  description: string;
  author?: string;
  url: string;
  tags: string;
  likes: number;
  artdate?: string;
  user?: Usuario;

}
