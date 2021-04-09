import { Component, OnInit } from '@angular/core';
import { Art } from '../interfaces/art';

@Component({
  selector: 'art-list',
  templateUrl: './art-list.component.html',
  styleUrls: ['./art-list.component.css']
})
export class ArtListComponent implements OnInit {

  title = 'Mi lista de artes';
  search="";
  artes: Art[] = [];

  constructor() { }

  ngOnInit(): void {

    this.artes=[ {

      artid: 5,
      title: 'Arte1',
      description: 'Bonita fotografía',
      author: 'Lucía',
      url: 'https://cdn.euroweeklynews.com/wp-content/uploads/2020/10/Thinking-of-getting-a-cat.png?x98854',
      tags: 'ei',
      likes: 90,
      artdate: '03-04-2021',
      userid: 25,
    },
    {

      artid: 5,
      title: 'Arte2',
      description: 'Hermosooooooo',
      author: 'Lucía',
      url: 'https://images-na.ssl-images-amazon.com/images/I/61CzZ1b1NhL.jpg',
      tags: 'ei',
      likes: 85,
      artdate: '01-04-2021',
      userid: 25,
    }
    ];
  }


  orderDate(): void {
    this.artes.sort((e1, e2) => e1.artdate.localeCompare(e2.artdate));
    this.artes = [...this.artes];
  }

  orderLikes(): void {
    this.artes.sort((e1, e2) => e2.likes - e1.likes);
    this.artes = [...this.artes];
  }


}
