import { Pipe, PipeTransform } from '@angular/core';
import { Usuario } from '../interfaces/usuario';

@Pipe({
  name: 'userFilter'
})
export class UserFilterPipe implements PipeTransform {

  transform(users: Usuario[], filtro: string): Usuario[] {
    return users.filter(
      e => e.username?.toLowerCase().includes(filtro.toLowerCase()) ||
           e.description?.toLowerCase().includes(filtro.toLowerCase())
    );
  }



}
