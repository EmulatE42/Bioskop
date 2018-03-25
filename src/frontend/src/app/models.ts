/*
 insert into korisnik values(1,"a","a","a","a","a",'k');
 insert into korisnik values(2,"b","b","b","b","b",'k');
 insert into korisnik values(3,"c","c","c","c","c",'m');
 */

export class Korisnik
{
  constructor( public id: number,
               public ime : string,
               public prezime : string,
               public korisnickoIme : string,
               public email : string,
               public lozinka : string,
               public tipKorisnika : string

  ) {}
}
