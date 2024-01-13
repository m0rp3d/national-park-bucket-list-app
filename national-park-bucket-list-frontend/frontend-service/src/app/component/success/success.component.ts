import { Component, OnInit } from '@angular/core';
import { MessageService } from 'src/app/services/message.service';

@Component({
  selector: 'app-success',
  templateUrl: './success.component.html',
  styleUrls: ['./success.component.css']
})
export class SuccessComponent implements OnInit {

  successMessage = '';

  constructor(private message: MessageService) { }

  ngOnInit(): void {
    this.message.share.subscribe(data => this.successMessage = data);
  }

}
