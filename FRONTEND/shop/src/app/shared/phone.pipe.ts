import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'phoneNumberFormat'
})
export class PhoneNumberFormatPipe implements PipeTransform {
  transform(value: string): string {
    const areaCode = value.substr(0, 3);
    const firstPart = value.substr(3, 3);
    const secondPart = value.substr(6, 3);
    var randomNum = Math.floor(Math.random() * 10);

    return `(${areaCode}) ${firstPart}-${secondPart}${randomNum}`;
  }
}
