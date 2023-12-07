using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class scriptPC : MonoBehaviour
{
    public Rigidbody2D rbd;
     private AudioSource som;
    public scriptVida vida;
    public Animator anim;
    public GameObject pe;
    public float velocidade = 5;
    public float velocidadeEsteira = 10;
    public float pulo = 250;
    public float kbForce;
    public float kbCount;
    public float kbTime;
    public bool knockRight;
    private bool chao;
    private bool direita = true;
    public LayerMask mascara;
    public LayerMask npc;
    private float x=0;
    private float y=0;
    RaycastHit2D hitChao;
    RaycastHit2D hitNPC;


    private void OnCollisionEnter2D(Collision2D collision){
       
        if(collision.gameObject.tag == "NPC" && hitNPC.collider == null){
            
            kbCount = kbTime;
            
            if (collision.transform.position.x <= transform.position.x){

                knockRight = false;
            }

            if (collision.transform.position.x > transform.position.x){

                knockRight = true;
            }

            vida.contVida--;
            anim.SetTrigger("dano");
            som.Play();
        }
    }

    // Start is called before the first frame update
    void Start()
    {
        rbd = GetComponent<Rigidbody2D>();
        anim = GetComponent<Animator>();
        som = GetComponent<AudioSource>();
        
    }

    // Update is called once per frame
    void Update(){
        knockBack();
        verificarChao();
        verificarNpc();
        caindo();
            
    
    }

    private void knockBack(){
        
        if(kbCount < 0){
            mover();
            pular();
        }
        else{
            if(knockRight == true){
                rbd.velocity = new Vector2(-kbForce*2, kbForce);
            }
            if(knockRight == false){
                rbd.velocity = new Vector2(kbForce*2, kbForce);
            }

        }
        kbCount-= Time.deltaTime;
    }
    private void mover(){
        //Mover
        x = Input.GetAxis("Horizontal");
        rbd.velocity = new Vector2(x * velocidade,
                                    rbd.velocity.y);

        
        //Animação
        if(x==0)
            anim.SetBool("parado", true);
        else
            anim.SetBool("parado", false);

        
        //Rotação
        if (direita && x<0 || !direita && x>0){

            direita = !direita;
            transform.Rotate(new Vector2(0,180));

        }

    }

    private void pular(){
         //pulo
         if(Input.GetKeyDown(KeyCode.Space) && chao){
            rbd.AddForce(new Vector2(0,pulo));
            anim.SetBool("pulando", true);          
        }
    }

    private void verificarChao(){
        hitChao = Physics2D.Raycast(pe.transform.position, -pe.transform.up, 0.1f, mascara);

        if(hitChao.collider != null){
            chao = true;
            transform.parent = hitChao.collider.transform;
            if(hitChao.collider.gameObject.tag == "Esteira")
                rbd.AddForce(new Vector2(velocidadeEsteira,0));       
            }

        else{
            chao = false;
            }

    }

    

    private void verificarNpc(){
        hitNPC = Physics2D.Raycast(pe.transform.position, -pe.transform.up, 0.1f, npc);

        if(hitNPC.collider != null){
           rbd.AddForce(new Vector2(0,20));
        }

    }
    
    
    private void caindo(){
        y = rbd.velocity[1];
        
        if(y<0){
            anim.SetBool("pulando", false);
            anim.SetBool("queda", true);
        }
        if(chao == true){
            anim.SetBool("queda", false);
        }

    }
}
