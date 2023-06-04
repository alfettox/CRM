import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';

@Component({
    selector: 'filter-textbox',
    template: `
    <label for="filter">Filter By name: </label>
        <input id="filter" type="text" [(ngModel)]="filter" >
    `
})
export class FilterTextboxComponent implements OnInit {
    
    private _filter: string = '';
    @Input() get filter() {
        return this._filter;
    }
    
    set filter(val: string) { 
        this._filter = val;
        this.changed.emit(this.filter); 

    }

     //up to the parent
    @Output() changed: EventEmitter<string> = new EventEmitter<string>();
    
    
    constructor() {}
    
    ngOnInit() {
        
    }
}