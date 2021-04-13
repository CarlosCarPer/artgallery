import { Art } from "./art";
import { Usuario } from "./usuario";
import { Comment } from "./comment";
import { Account } from "./account";

export interface ArtsResponse {
  arts: Art[];
}

export interface ArtResponse {
  art: Art;
}

export interface TokenResponse {
  accessToken: string;
}

export interface UsuariosResponse {
  users: Usuario[];
}

export interface UsuarioResponse {
  user: Usuario;
}

export interface TokenResponse {
  accessToken: string;
}

export interface AccountsResponse {
  accounts: Account[];
}

export interface AccountResponse {
  account: Account;
}

export interface TokenResponse {
  accessToken: string;
}

export interface CommentsResponse {
  comments: Comment[];
}

export interface CommentResponse {
  comment: Comment;
}

export interface TokenResponse {
  accessToken: string;
}
