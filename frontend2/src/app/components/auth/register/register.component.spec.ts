import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { By } from '@angular/platform-browser';
import { RegisterComponent } from './register.component';

describe('RegisterComponent', () => {
  let component: RegisterComponent;
  let fixture: ComponentFixture<RegisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterComponent ],
      imports: [ ReactiveFormsModule ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should toggle password visibility', () => {
    const passwordInput = fixture.debugElement.query(By.css('#password')).nativeElement;
    const toggleIcon = fixture.debugElement.query(By.css('.toggle-password')).nativeElement;

    expect(passwordInput.type).toBe('password');

    toggleIcon.click();
    fixture.detectChanges();
    expect(passwordInput.type).toBe('text');

    toggleIcon.click();
    fixture.detectChanges();
    expect(passwordInput.type).toBe('password');
  });

  it('should validate email format', () => {
    const emailInput = component.registroForm.controls['email'];
    const emailElement = fixture.debugElement.query(By.css('#email')).nativeElement;

    emailInput.setValue('invalid-email');
    fixture.detectChanges();
    expect(emailInput.invalid).toBeTruthy();
    expect(emailElement.classList).toContain('ng-invalid');

    emailInput.setValue('valid.email@example.com');
    fixture.detectChanges();
    expect(emailInput.valid).toBeTruthy();
    expect(emailElement.classList).toContain('ng-valid');
  });

  it('should show error message for invalid email', () => {
    const emailInput = component.registroForm.controls['email'];
    emailInput.setValue('invalid-email');
    emailInput.markAsTouched();
    fixture.detectChanges();

    const errorMessage = fixture.debugElement.query(By.css('.error-message')).nativeElement;
    expect(errorMessage).toBeTruthy();
    expect(errorMessage.textContent).toContain('El email no es válido.');
  });

  it('should submit the form if valid', () => {
    spyOn(component, 'onSubmit').and.callThrough();

    component.registroForm.controls['name'].setValue('John');
    component.registroForm.controls['lastName'].setValue('Doe');
    component.registroForm.controls['email'].setValue('john.doe@example.com');
    component.registroForm.controls['password'].setValue('password123');
    component.registroForm.controls['terms'].setValue(true);

    fixture.debugElement.query(By.css('form')).triggerEventHandler('ngSubmit', null);
    fixture.detectChanges();

    expect(component.onSubmit).toHaveBeenCalled();
    expect(component.registroForm.valid).toBeTruthy();
  });

  it('should not submit the form if invalid', () => {
    spyOn(component, 'onSubmit').and.callThrough();

    component.registroForm.controls['name'].setValue('');
    component.registroForm.controls['lastName'].setValue('');
    component.registroForm.controls['email'].setValue('invalid-email');
    component.registroForm.controls['password'].setValue('');
    component.registroForm.controls['terms'].setValue(false);

    fixture.debugElement.query(By.css('form')).triggerEventHandler('ngSubmit', null);
    fixture.detectChanges();

    expect(component.onSubmit).toHaveBeenCalled();
    expect(component.registroForm.invalid).toBeTruthy();
  });
});
