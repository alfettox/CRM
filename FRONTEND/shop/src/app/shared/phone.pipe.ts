import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'phoneNumberFormat'
})
export class PhoneNumberFormatPipe implements PipeTransform {
  transform(value: string): string {
    const phoneNumber = value.replace(/\D/g, '');

    const formattedNumber = `(${phoneNumber.substring(0, 3)}) - ${phoneNumber.substring(3, 9)}`;

    return formattedNumber;
  }
}
