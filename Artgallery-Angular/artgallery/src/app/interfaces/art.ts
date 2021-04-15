import { Usuario } from "./usuario";

export interface Art {

  artId?: number;
  title: string;
  description: string;
  author?: string;
  url: string;
  tags: string;
  likes: number;
  artDate?: string;
  comments?: Comment[];
}
