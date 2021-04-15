export interface Comment {

  commentId?: number;
	userid?: number;
	commentary?: string;
	likes?: number;
	commentDate?: string;
  comments: Comment[];

}
