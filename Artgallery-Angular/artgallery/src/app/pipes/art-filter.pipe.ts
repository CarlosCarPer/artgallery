import { Pipe, PipeTransform } from '@angular/core';
import { Art } from '../interfaces/art';

@Pipe({
  name: 'artFilter'
})
export class ArtFilterPipe implements PipeTransform {

  transform(arts: Art[], filtro: string): Art[] {
    return arts.filter(
      e => e.title.toLowerCase().includes(filtro.toLowerCase()) ||
           e.description.toLowerCase().includes(filtro.toLowerCase())
    );
  }
}
